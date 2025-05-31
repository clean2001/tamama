package org.tamama.member.domain.value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.tamama.member.domain.enums.TierType;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class Tier implements Serializable {
    private TierType tierType;
    private int tierValue;
}
