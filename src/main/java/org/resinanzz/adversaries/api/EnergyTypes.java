package org.resinanzz.adversaries.api;

public class EnergyTypes {
    private final String name;

    private EnergyTypes(String name) {
        this.name = name;
    }
    public static final EnergyTypes BLOOD = new EnergyTypes("blood");
    public static final EnergyTypes SULPHERE = new EnergyTypes("sulphere");
    public static final EnergyTypes PHOSPHENES = new EnergyTypes("phosphenes");
    public static final EnergyTypes FAYE = new EnergyTypes("faye");
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
