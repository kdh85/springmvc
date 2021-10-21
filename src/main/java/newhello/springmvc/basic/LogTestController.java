package newhello.springmvc.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogTestController {

	@RequestMapping("/log-test")
	public String logTest(){
		String name = "Spring";

		log.info(" info log={}", name);
		log.debug(" info log={}", name);
		log.trace(" info log={}", name);
		log.warn(" info log={}", name);
		log.error(" info log={}", name);

		return "ok";
	}
}
