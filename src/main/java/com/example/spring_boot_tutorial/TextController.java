package com.example.spring_boot_tutorial;

//import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;

@RestController
public class TextController {

	@GetMapping("/text")
	public String getText() {
        MemoryFile mFile = new MemoryFile("memory.csv");
        String line = mFile.readFileLine(1);
        if (line != "") {
            return line;
        } else {
            return "line not found";
        }
	}

    @PostMapping(path = "/text", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String postText(@ModelAttribute("text") String textFormData ) {
        //String text = String.valueOf(textFormData.get("text"));
        MemoryFile mFile = new MemoryFile("memory.csv");
        if (mFile.addLineToFile(textFormData)) {
            return "You posted: " + textFormData + "test";
        } else {
            return "Something went wrong";
        }
        
    }

}