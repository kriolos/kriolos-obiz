package io.github.kriolsolutions.krospos.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class KriolosPosWebapiApplication {

    com.openbravo.pos.forms.StartPOS pos = new com.openbravo.pos.forms.StartPOS();
    
    public void run(String[] args){
        com.openbravo.pos.forms.StartPOS.main(args);
    }
    
	public static void main(String[] args) {
		//SpringApplication.run(KriolosPosWebapiApplication.class, args);
                
            var cx = new SpringApplicationBuilder(KriolosPosWebapiApplication.class)
                    .headless(false).run(args);
            
            var app = cx.getBean(KriolosPosWebapiApplication.class);
            app.run(args);
	}

}
