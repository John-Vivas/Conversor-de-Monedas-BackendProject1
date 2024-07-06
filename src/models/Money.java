package models;

import java.util.HashMap;

public record Money(String base_code, HashMap<String, Double> conversion_rates
                    ) {
}
