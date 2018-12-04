package edu.sga.core.configuration;
import edu.sga.core.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	@Autowired
	@Qualifier("userDetailService")
	private UserDetailService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Value("${app.oauth.tokenTimeout}")
	private int expiration;
	
	@Value("${app.client.id}")
	private String clienteID;
	@Value("${app.client.secret}")
	private String clienteSecret;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.authenticationManager(authenticationManager);
		configurer.userDetailsService(userDetailsService);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(clienteID).secret(clienteSecret).accessTokenValiditySeconds(expiration)
				.scopes("read", "write").authorizedGrantTypes("password", "refresh_token","authorization_code").resourceIds("oauth2-resource");
		System.out.println("Configuracion....");
	}
}
