import entities.Post;
import helpers.PostHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class PostTest {

    private PostHelper postHelper;
    private static final String POST_TITLE = "This is a title";
    private static final String POST_BODY = "This is a body";

    @BeforeClass
    public void init(){
        this.postHelper = new PostHelper();
    }

    @Test
    public void getPostById(){
        Post testPost = postHelper.getPostById(1);
        Assert.assertEquals(testPost.getId(),Long.valueOf(1));
    }

    @Test
    public void getPosts(){
        List<Post> postList = postHelper.getPosts();
        postList.forEach(post -> {
            System.out.println(post.getTitle());
        });
    }

    @Test
    public void createPost(){
        Post post = postHelper.generatePost(null,1,POST_TITLE,POST_BODY);
        Post createdPost = postHelper.createPost(post);
        Assert.assertNotNull(createdPost.getId());
        Assert.assertEquals(createdPost.getTitle(),POST_TITLE);
        Assert.assertEquals(createdPost.getBody(),POST_BODY);
    }

    @Test
    public void delete(){
         postHelper.deletePost(1);
    }

    @Test
    public void updatePost(){
        Post originalPost = postHelper.getPostById(1);
        originalPost.setTitle(POST_TITLE);
        originalPost.setBody(POST_BODY);
        Post updatedPost = postHelper.updatePost(1,originalPost);
        Assert.assertEquals(updatedPost.getTitle(),POST_TITLE);
        Assert.assertEquals(updatedPost.getBody(),POST_BODY);
    }


}
