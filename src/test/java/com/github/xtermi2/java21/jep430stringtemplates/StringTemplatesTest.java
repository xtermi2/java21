package com.github.xtermi2.java21.jep430stringtemplates;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTemplatesTest {

    @Test
    void toJson() {
        final StringTemplates java = new StringTemplates("Java", 21);

        assertThat(java.toJson())
                .isEqualTo("""
                        {
                            "name": "Java",
                            "age": 21
                        }
                        """);
    }
}