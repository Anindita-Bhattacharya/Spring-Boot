package firstspring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
