package com.miftakhov.spring;

import org.springframework.stereotype.Component;

@Component
public class PopMusic implements Music{
    @Override
    public String getSong() {
        return "Britney Spears - Toxic";
    }
}
