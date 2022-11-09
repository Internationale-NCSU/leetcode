import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WebsitePagination {

   public String[] fetchItemsToDisplay(String[][] items, int sortPara, int sortOrder, int itemPerPage, int pageNum){
        boolean isAscending =  sortOrder==0? true:false;
       Arrays.sort(items,(a,b)->{
           if(isAscending){
               return Integer.valueOf(a[sortPara])-Integer.valueOf(b[sortPara]);
           }else {
               return Integer.valueOf(b[sortPara])-Integer.valueOf(a[sortPara]);
           }
       });
       String[] pageItem = new String[itemPerPage];
       for (int i = 0; i < itemPerPage; i++) {
           pageItem[i] = items[pageNum-1+i][0];
       }
       return pageItem;
   }
    @Test
    public void test(){
        String[][] items = {
                {"item1","10","15"},
                {"item2","3","4"},
                {"item3","17","8"}
        };
        String[] item = fetchItemsToDisplay(items,1,0,2,1);
        System.out.println(item[0]);
        System.out.println(item[1]);
    }

}
