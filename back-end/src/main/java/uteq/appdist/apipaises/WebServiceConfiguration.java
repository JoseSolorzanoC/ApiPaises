package uteq.appdist.apipaises;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    //Países
    @Bean(name = "countries")
    public DefaultWsdl11Definition defaulCountrytWsdl11Definition(XsdSchema countrySchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("countriesPort");
        wsdl11Definition.setLocationUri("/ws/country");
        wsdl11Definition.setTargetNamespace("http://country.interfaces.generated.soapws.apipaises.appdist.uteq");
        wsdl11Definition.setSchema(countrySchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countrySchema() {
        return new SimpleXsdSchema(new ClassPathResource("./soapws-xsds/country.xsd"));
    }

    //Provincias
    @Bean(name = "provinces")
    public DefaultWsdl11Definition defaultProvinceWsdl11Definition(XsdSchema provinceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("provincesPort");
        wsdl11Definition.setLocationUri("/ws/province");
        wsdl11Definition.setTargetNamespace("http://province.interfaces.generated.soapws.apipaises.appdist.uteq");
        wsdl11Definition.setSchema(provinceSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema provinceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("./soapws-xsds/province.xsd"));
    }

    //Ciudades
    @Bean(name = "cities")
    public DefaultWsdl11Definition defaulCitytWsdl11Definition(XsdSchema citySchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("citiesPort");
        wsdl11Definition.setLocationUri("/ws/city");
        wsdl11Definition.setTargetNamespace("http://city.interfaces.generated.soapws.apipaises.appdist.uteq");
        wsdl11Definition.setSchema(citySchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema citySchema() {
        return new SimpleXsdSchema(new ClassPathResource("./soapws-xsds/city.xsd"));
    }


    //Usuarios
    @Bean(name = "users")
    public DefaultWsdl11Definition defaultUserWsdl11Definition(XsdSchema userSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("usersPort");
        wsdl11Definition.setLocationUri("/ws/user");
        wsdl11Definition.setTargetNamespace("http://user.interfaces.generated.soapws.apipaises.appdist.uteq");
        wsdl11Definition.setSchema(userSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema userSchema() {
        return new SimpleXsdSchema(new ClassPathResource("./soapws-xsds/users.xsd"));
    }

    
}
