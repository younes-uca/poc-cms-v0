package ma.sqli.peps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ma.sqli.peps.bean.core.common.SlotType;
import ma.sqli.peps.service.facade.admin.common.SlotTypeAdminService;
import ma.sqli.peps.zynerator.security.bean.Permission;
import ma.sqli.peps.zynerator.security.bean.Role;
import ma.sqli.peps.zynerator.security.bean.User;
import ma.sqli.peps.zynerator.security.common.AuthoritiesConstants;
import ma.sqli.peps.zynerator.security.service.facade.RoleService;
import ma.sqli.peps.zynerator.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
//@EnableElasticsearchRepositories("ma.sqli.peps.dao")
//@EnableFeignClients("ma.sqli.peps.required.facade")
public class PepsApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(PepsApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
        for (int i = 1; i <= 5; i++) {
            slotTypeService.findOrSave(new SlotType(i * 1L, "slot-type-" + i));
        }
        return (args) -> {
            if (true) {


                // Role admin


                User userForAdmin = new User("admin");

                Role roleForAdmin = new Role();
                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
                List<Permission> permissionsForAdmin = new ArrayList<>();
                addPermissionForAdmin(permissionsForAdmin);
                roleForAdmin.setPermissions(permissionsForAdmin);
                if (userForAdmin.getRoles() == null)
                    userForAdmin.setRoles(new ArrayList<>());

                userForAdmin.getRoles().add(roleForAdmin);
                userService.save(userForAdmin);
            }
        };
    }


    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return 10L * i;
    }

    private static Integer fakeInteger(String attributeName, int i) {
        return 10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return BigDecimal.valueOf(i * 1L * 10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }

    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }

    private static void addPermissionForAdmin(List<Permission> permissions) {
        permissions.add(new Permission("Slot.edit"));
        permissions.add(new Permission("Slot.list"));
        permissions.add(new Permission("Slot.view"));
        permissions.add(new Permission("Slot.add"));
        permissions.add(new Permission("Slot.delete"));
        permissions.add(new Permission("SlotType.edit"));
        permissions.add(new Permission("SlotType.list"));
        permissions.add(new Permission("SlotType.view"));
        permissions.add(new Permission("SlotType.add"));
        permissions.add(new Permission("SlotType.delete"));
        permissions.add(new Permission("ContainerType.edit"));
        permissions.add(new Permission("ContainerType.list"));
        permissions.add(new Permission("ContainerType.view"));
        permissions.add(new Permission("ContainerType.add"));
        permissions.add(new Permission("ContainerType.delete"));
        permissions.add(new Permission("ContainerVersion.edit"));
        permissions.add(new Permission("ContainerVersion.list"));
        permissions.add(new Permission("ContainerVersion.view"));
        permissions.add(new Permission("ContainerVersion.add"));
        permissions.add(new Permission("ContainerVersion.delete"));
        permissions.add(new Permission("ProductType.edit"));
        permissions.add(new Permission("ProductType.list"));
        permissions.add(new Permission("ProductType.view"));
        permissions.add(new Permission("ProductType.add"));
        permissions.add(new Permission("ProductType.delete"));
        permissions.add(new Permission("PdpContainer.edit"));
        permissions.add(new Permission("PdpContainer.list"));
        permissions.add(new Permission("PdpContainer.view"));
        permissions.add(new Permission("PdpContainer.add"));
        permissions.add(new Permission("PdpContainer.delete"));
    }

    @Autowired
    private SlotTypeAdminService slotTypeService;

}


