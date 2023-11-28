package org.sid.Customerservice.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//indique que je peut changer les configurations de config-repo
@RefreshScope

public class CustomerConfigTestControler {

	@Value("${customer.params.p1}")
	private String p1;
	@Value("${customer.params.p2}")
	private String p2;
	@Value("${global.params.p1}")
	private String x;
	@Value("${global.params.p2}")
    private String y;
	@GetMapping("/params")
	public Map<String, String> params(){
		return Map.of(
				"p1",p1,"p2",p2,"x",x,"y",y
				);
	}
}
