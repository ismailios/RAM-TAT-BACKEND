package ma.itroad.ram.tat.coref.service.web.rest.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface PageUtil { /**
     * Create a {@link org.springframework.data.domain.Page} from a {@link java.util.List} of objects
    *
    * @param list list of objects
    * @param pageable pagination information.
    * @param <T> type of object
    * @return page containing objects, and attributes set according to pageable
    * @throws java.lang.IllegalArgumentException - if list is null
    */
   static <T> Page<T> createPageFromList(List<T> list, Pageable pageable) {
       if (list == null) {
           throw new IllegalArgumentException("To create a Page, the list mustn't be null!");
       }

       int startOfPage = pageable.getPageNumber() * pageable.getPageSize();
       if (startOfPage > list.size()) {
           return new PageImpl<>(new ArrayList<>(), pageable, 0);
       }

       int endOfPage = Math.min(startOfPage + pageable.getPageSize(), list.size());
       return new PageImpl<>(list.subList(startOfPage, endOfPage), pageable, list.size());
   }
}



