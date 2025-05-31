package org.tamama.member.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.tamama.member.domain.enums.TierType;
import org.tamama.member.domain.value.Tier;

import java.util.HashMap;
import java.util.Map;

@Converter
public class TierConverter implements AttributeConverter<Tier, String> {
    private static final Map<String, TierType> TIER_MAP = new HashMap<>();

    public TierConverter() {
        for(TierType tier : TierType.values()) {
            TIER_MAP.put(tier.toString(), tier);
        }
    }
    @Override
    public String convertToDatabaseColumn(Tier tier) {
        // ex. welcome_1
        return new StringBuilder()
                .append(tier.getTierType().getValue())
                .append("_")
                .append(String.valueOf(tier.getTierValue()))
                .toString();
    }

    @Override
    public Tier convertToEntityAttribute(String s) {
        String[] splitted = s.split("_");
        String tierType = splitted[0];
        String tierValue = splitted[1];

        return new Tier(TIER_MAP.get(tierType), Integer.parseInt(tierValue));
    }
}
