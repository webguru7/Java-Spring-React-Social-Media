package socialMediaApp.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialMediaApp.requests.PostAddRequest;
import socialMediaApp.responses.post.PostGetResponse;
import socialMediaApp.services.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<PostGetResponse>> getAll(){
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PostGetResponse> getById(@PathVariable int id){
        return new ResponseEntity<>(postService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/getallbyuser/{userId}")
    public ResponseEntity<List<PostGetResponse>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(postService.getAllByUser(userId),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody PostAddRequest postAddRequest){
        postService.add(postAddRequest);
        return new ResponseEntity<>("Post Added",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        postService.delete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
