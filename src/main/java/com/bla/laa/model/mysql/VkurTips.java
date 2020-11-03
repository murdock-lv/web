package com.bla.laa.model.mysql;

import java.util.stream.Stream;

public class VkurTips {


    public enum TipsEnum {

        COUNTRY(101),
        AREA(102),      //AW_RAJONS
        CITY(104),      //AW_PILSETA
        PARISH(105),    //AW_PAGASTS
        VILLAGE(106),   //AW_CIEMS
        STREET(107),    //AW_IELA
        BUILDING(108),  //AW_NLIET
        FLAT(109),      //AW_DZIV
        COUNTY(113),    //AW_NOVADS
        NOTSET(0);

        private int val;

        TipsEnum(int val) {
            this.val = val;
        }

        TipsEnum(String val) {
            this.val = Integer.valueOf(val);
        }

        public static TipsEnum of(int val) {
            return Stream.of(TipsEnum.values())
                    .filter(p -> p.getVal() == val)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public int getVal() {
            return val;
        }

        public int getTipsEnum() {
            return val;
        }

        public String getName() {
            return this.name();
        }

    }

}
