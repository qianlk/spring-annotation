package org.example.b05_anno_others.extensions.imo;

import org.example.b05_anno_others.domain.User;
import org.example.b05_anno_others.extensions.ValidateExtensionService;
import org.springframework.stereotype.Component;

/**
 * @author Qianlk
 */
@Component
public class ValidateExtensionServiceImpl implements ValidateExtensionService {
    @Override
    public boolean checkUser(User user) {
        if (user !=null && user.getNickname().contains("孙子")) {
            return false;
        }
        return true;
    }
}
