package entities;

import java.util.function.Consumer;

public class Post {


    private Long id;
    private Long userId;
    private String title;
    private String body;

    private Post(Long id, Long userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static class PostBuilder {

        public Long id;
        public Long userId;
        public String title;
        public String body;

        public PostBuilder with(Consumer<PostBuilder> builderFunction){
            builderFunction.accept(this);
            return this;
        }

        public Post buildPost(){
            return new Post(id,userId,title,body);
        }

    }
}
