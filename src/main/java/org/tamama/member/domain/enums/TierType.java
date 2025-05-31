package org.tamama.member.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum TierType {
    WELCOME("welcome"),
    GREEN("green"),
    GOLD("gold");

    private final String value;
}
