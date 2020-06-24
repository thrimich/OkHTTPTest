package services;

import entities.Post;
import helpers.PostHelper;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class PostService extends CommonService {

    private OkHttpClient okHttpClient;
    private String url;
    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);


    public PostService() {
        this.okHttpClient = new OkHttpClient();
    }

    public Post getPost(Integer postId){
        this.servicePath = format("/posts/%s", postId);
        this.url = this.serviceEndpoint + this.servicePath;
        LOGGER.info("Fetching post: " + url);
        return get(this.okHttpClient,this.url,"",Post.class);
    }

    public List<Post> getPosts(){
        this.servicePath = "/posts";
        this.url = this.serviceEndpoint + this.servicePath;
        LOGGER.info("Fetching posts: " + url);
        return Arrays.asList(getForList(this.okHttpClient,this.url,"",Post[].class));
    }

    public Post updatePost(Integer postId, Post post){
        this.servicePath = format("/posts/%s",postId);
        this.url = this.serviceEndpoint + this.servicePath;
        LOGGER.info("Modifying post: " + url);
        return put(this.okHttpClient,this.url,"",post,Post.class);
    }

    public List<Post> updatePosts(List<Post> posts){
        this.servicePath = "/posts";
        this.url = this.serviceEndpoint + this.servicePath;
        LOGGER.info("Modifying posts: " + url);
        return Arrays.asList(put(this.okHttpClient,this.url,"",posts,Post[].class));
    }

    public Post createPost(Post post){
        this.servicePath = "/posts";
        this.url = this.serviceEndpoint + this.servicePath;
        LOGGER.info("Creating post: " + url);
        return post(this.okHttpClient,this.url,"",post,Post.class);
    }

    public List<Post> createPosts(List<Post> posts){
        this.servicePath = "/posts";
        this.url = this.serviceEndpoint + this.servicePath;
        LOGGER.info("Creating posts: " + url);
        return Arrays.asList(postForList(this.okHttpClient,this.url,"",posts,Post[].class));
    }

    public void deletePost(Integer postId){
        this.servicePath = format("/posts/%s",postId);
        this.url = this.serviceEndpoint + this.servicePath;
        LOGGER.info("Deleting post: " + url);
        delete(this.okHttpClient,this.url,"",Object.class);
    }



    @Override
    protected String buildEndPoint() {
        //ToDo -> Move to properties.
        return "https://jsonplaceholder.typicode.com";
    }

    @Override
    protected void addAuthenticationHeaders() {
        /* Do Something */
    }
}
