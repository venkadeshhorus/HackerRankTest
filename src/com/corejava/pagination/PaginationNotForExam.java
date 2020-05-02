package com.corejava.pagination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PaginationNotForExam {
	String[] paginate(int num, String[] results) {
        if (num < 1) {
            throw new IllegalArgumentException();
        }
        if (results == null || results.length == 0) {
            return new String[] {""};
        }
        List<Host> hosts = Arrays.stream(results).map(Host::new).collect(Collectors.toList());
        LinkedHashMap<Host, Host> map = new LinkedHashMap<>(results.length, 0.75f, true);
        hosts.forEach(h -> map.put(h, h));
        Dummy dummy = new Dummy("0,D,D,D");
        List<Host> res = new ArrayList<>(results.length);

        int pageNum = getPages(results.length, num);
        for (int i = 0; i < pageNum; i++) {
            List<Host> singlePageListing = new ArrayList<>(num);
            Set<Integer> distinctHostIds = new HashSet<>();
            Iterator<Map.Entry<Host, Host>> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Host, Host> e = iter.next();
                if (distinctHostIds.contains(e.getKey().getHostId())) {
                    continue;
                }
                singlePageListing.add(e.getKey());
                iter.remove();
                distinctHostIds.add(e.getKey().getHostId());
                if (singlePageListing.size() == num) {
                    break;
                }
            }

            // padding
            if (singlePageListing.size() < num) {
                Iterator<Map.Entry<Host, Host>> iter2 = map.entrySet().iterator();
                while (iter2.hasNext()) {
                    Map.Entry<Host, Host> e = iter2.next();
                    singlePageListing.add(e.getKey());
                    iter2.remove();
                    if (singlePageListing.size() == num) {
                        break;
                    }
                }
            }

            singlePageListing.add(dummy);
            res.addAll(singlePageListing);
        }
        return res.stream().map(Host::getContent).toArray(String[]::new);
    } // paginate method

   
    int getPages(int resultSize, int num) {
        return (int) Math.ceil((double) resultSize / num);
    }

    class Dummy extends Host {
        public Dummy(String result) {
            super(result);
        }
        @Override
        public String getContent() {
            return "";
        }
    }

   
    class Host {
        private int hostId;
        private String content;
        public Host(String result) {
            if (result == null || result.length() == 0) {
                throw new IllegalArgumentException();
            }
            String[] fields = result.split(",");
            if (fields.length != 4) {
                throw new IllegalArgumentException();
            }
            this.hostId = Integer.parseInt(fields[0]);
            this.content = result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Host host = (Host) o;

            if (hostId != host.hostId) {
                return false;
            }
            return !(content != null ? !content.equals(host.content) : host.content != null);

        }

        @Override
        public int hashCode() {
            int result = hostId;
            result = 31 * result + (content != null ? content.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Host{" +
                    "hostId=" + hostId +
                    ", content='" + content + '\'' +
                    '}';
        }

        public int getHostId() {
            return hostId;
        }

        public void setHostId(int hostId) {
            this.hostId = hostId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
    
    public static void main(String[] args) {
        String[] results = new String[] {
                "1,2,300,A",
                "4,2,300,B",
                "20,2,300,C",
                "6,2,300,D",
                "6,2,300,E",
                "1,2,300,F",
                "6,2,300,G",
                "7,2,300,H",
                "6,2,300,I",
                "2,2,300,M",
                "2,2,300,N",
                "3,2,300,X",
                "2,2,300,Y",
        };
        PaginationNotForExam p2 = new PaginationNotForExam();
        String[] res = p2.paginate(4, results);
        Arrays.stream(res).forEach(System.out::println);
//
//        results = new String[] {
//                "1,2,300,A",
//                "1,2,300,B",
//                "1,2,300,C",
//                "1,2,300,D",
//                "1,2,300,E",
//                "1,2,300,F",
//                "2,2,300,G",
//        };
//        res = p2.paginate(3, results);
//        Arrays.stream(res).forEach(System.out::println);
    }

}
