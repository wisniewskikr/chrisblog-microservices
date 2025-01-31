package pl.kwi.chrisblog.controllers.abstr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public abstract class AbstractController {
	
	@Autowired
    private BuildProperties buildProperties;
	
	@ModelAttribute("applicationVersion")
    public String getApplicationVersion() {
        return buildProperties.getVersion();
    }

}
