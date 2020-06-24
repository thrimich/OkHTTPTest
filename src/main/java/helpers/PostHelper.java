package helpers;

import entities.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.PostService;

import java.util.List;

public class PostHelper {

    private PostService postService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PostHelper.class);

    public PostHelper() {
        this.postService = new PostService();
    }


    public Post getPostById(Integer postId){
        LOGGER.info("Trying to get post by ID...");
        return postService.getPost(postId);
    }

    public List<Post> getPosts(){
        LOGGER.info("Trying to get posts...");
        return postService.getPosts();
    }

    public Post updatePost(Integer postId, Post post){
        LOGGER.info("Trying to update post by ID...");
        return postService.updatePost(postId, post);
    }

    public List<Post> updatePosts(List<Post> posts){
        LOGGER.info("Trying to update posts...");
        return postService.updatePosts(posts);
    }

    public Post createPost(Post post){
        LOGGER.info("Trying to create post...");
        return postService.createPost(post);
    }

    public List<Post> createPosts(List<Post> posts) {
        LOGGER.info("Trying to create posts...");
        return postService.createPosts(posts);
    }

    public void deletePost(Integer id){
        LOGGER.info("Trying to delete post...");
        postService.deletePost(id);
    }

        public Post generatePost(Integer postId, Integer userId, String title, String body){
        return new Post.PostBuilder().with(
                $ -> {
                    if (postId != null){
                        $.id = Long.valueOf(postId);
                    }
                    $.userId = Long.valueOf(userId);
                    $.title = title;
                    $.body = body;
                }
        ).buildPost();
    }

}


