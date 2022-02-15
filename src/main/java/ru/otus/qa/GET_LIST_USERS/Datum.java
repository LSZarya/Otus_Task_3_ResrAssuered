
package ru.otus.qa.GET_LIST_USERS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class Datum {

    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
