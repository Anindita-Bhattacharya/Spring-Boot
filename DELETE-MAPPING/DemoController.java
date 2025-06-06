package firstspring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController 
{
	@Autowired
    private Repository userRepository;
	@GetMapping("/m")
	public String get()
	{
		return "welcome";
	}
	@PostMapping("/addUser")
    public User add(@RequestBody User u)
    {
		System.out.println("Data added");

		return userRepository.save(u);
    }
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> update(@RequestBody User u, @PathVariable("id") long id) {
	    if (userRepository.existsById(id)) {
	        u.setId(id);
	        System.out.println("Data updated");
	        return ResponseEntity.ok(userRepository.save(u)); // Returning the updated user
	    } else {
	        System.out.println("User with ID " + id + " not found");
	        return ResponseEntity.status(404).body("User not found"); // Still returning an appropriate message
	    }
	}
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
	    if (userRepository.existsById(id)) {
	        userRepository.deleteById(id);
	        System.out.println("User deleted");
	        return ResponseEntity.ok("User deleted successfully");
	    } else {
	        System.out.println("User with ID " + id + " not found");
	        return ResponseEntity.status(404).body("User not found");
	    }
	}


}
