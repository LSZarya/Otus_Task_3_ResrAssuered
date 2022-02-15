
package ru.otus.qa.GET_LIST_USERS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class ListUser {

    private List<Datum> data;
    private Long page;
    private Long perPage;
    private Support support;
    private Long total;
    private Long totalPages;

}
