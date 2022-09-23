import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode811_SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer>  map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] splits = cpdomains[i].split(" ");
            int num = Integer.valueOf(splits[0]);
            String domain = splits[1];
            List<String> list = domainHelper(domain);
            for (String s : list) {
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+num);
                }else {
                    map.put(s,num);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String cpdomain = "";
            cpdomain = cpdomain+entry.getValue()
                        + " " + entry.getKey();
            result.add(cpdomain);
        }
        return result;
    }
    public List<String> domainHelper(String domain){
        List<String> result = new ArrayList<>();
        String[] subdomains = domain.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = subdomains.length-1; i >=0 ; i--) {
            if(i==subdomains.length-1) {
                sb.append(subdomains[i]);
            }else {
                sb.insert(0,subdomains[i]+".");
            }
            result.add(sb.toString());
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(subdomainVisits(new String[]{
            "900 google.mail.com",
                "50 yahoo.com",
                "1 intel.mail.com",
                "5 wiki.org"
        }));
    }
}
