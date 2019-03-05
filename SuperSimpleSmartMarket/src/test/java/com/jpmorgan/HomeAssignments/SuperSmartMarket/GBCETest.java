package com.jpmorgan.HomeAssignments.SuperSmartMarket;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.jpmorgam.HomeAssignment.SuperSimpleSmartMarket.enums.StockType;
import com.jpmorgan.HomeAssignments.SuperSimpleSmartMarket.GBCE;
import com.jpmorgan.HomeAssignments.SuperSimpleSmartMarket.Stock;



public class GBCETest {

	@Test
	public void testAllShareIndex() {
        HashMap<String, Stock> db = new HashMap<String, Stock>();
        db.put("TEA", new Stock("TEA", StockType.COMMON, 0.0, 0.0, 100.0));
        db.put("POP", new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0));
        db.put("ALE", new Stock("ALE", StockType.COMMON, 23.0, 0.0, 60.0));
        db.put("GIN", new Stock("GIN", StockType.PREFERRED, 8.0, 0.2, 100.0));
        db.put("JOE", new Stock("JOE", StockType.COMMON, 13.0, 0.0, 250.0));
        for (Stock stock: db.values()) {
            // Record some trades
        	for (int i=1; i <= 10; i++) {
        		stock.buy(1, 1.0);
        		stock.sell(1, 1.0);
        	}
        }
        Double GBCEallShareIndex = GBCE.allShareIndex(db);
        assertEquals(1.379729661461215, GBCEallShareIndex, 0.0);
	}

}
