package newhello.springmvc.basic.requestmapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MappingController {

	@GetMapping("/hello-basic")
	public String helloBasic(){
		log.info("helloBasic");
		return "ok";
	}

	/**
	 * PathVariable 사용
	 * 변수명 같으면 생략 가능
	 * @PathVariable("userId") String userId -> @PathVariable userId
	 * /mapping/userA
	 */
	@GetMapping("/mapping/{userId}")
	public String mappingPath(@PathVariable("userId") String userId){
		log.info("mappingPath userId ={}",userId);
		return "ok";
	}

	/**
	 * PathVariable 다중 사용
	 */
	@GetMapping("/mapping/user/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable("userId") String userId, @PathVariable("orderId") Long orderId){
		log.info("mappingPath userId ={}, orderId={}",userId, orderId);
		return "ok";
	}

	/**
	 * 파라메터 추가 매핑
	 * params = "mode",
	 * params = "!mode",
	 * params = "mode=debug",
	 * params = "mode!=debug",
	 * params = {"mode=debug","data=good"}
	 */
	@GetMapping(value = "/mapping-param", params = "mode=debug")
	public String mappingParam(){
		log.info("mappingParam");
		return "ok";
	}

	/**
	 * 특정 헤더로 추가 매핑
	 * headers="mode",
	 * headers="!mode",
	 * headers="mode=debug",
	 * headers="mode!=debug"
	 */
	@GetMapping(value = "/mapping-header",headers = "mode=debug")
	public String mappingHeader(){
		log.info("mappingHeader");
		return "ok";
	}

	/**
	 * Content-Type 헤더 기반 추가 매핑 Media Type
	 * consumes="application/json"
	 * consumes="!application/json"
	 * consumes="application/*"
	 * consumes="*\/*"
	 * MediaType.APPLICATION_JSON_VALUE
	 */
	@PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String mappingConsumes(){
		log.info("mappingConsumes");
		return "ok";
	}

	/**
	 * Accept 해더 기반 Media Type
	 * produce 선언된 타입을 해더의 Accept 와 비교.
	 * produce = "text/html"
	 * produce = "!text/html"
	 * produce = "text/*"
	 * produce = "*\/*"
	 * MediaType.APPLICATION_JSON_VALUE
	 */
	@PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
	public String mappingProduces() {
		log.info("mappingProduces");
		return "ok";
	}
}
