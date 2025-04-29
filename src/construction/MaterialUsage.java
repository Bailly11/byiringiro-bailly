package construction;

public class MaterialUsage extends ConstructionMaterial {
    public MaterialUsage(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void useMaterial() {
        if (materialBalance - materialQuantity >= 2) {
            materialBalance -= materialQuantity;
            System.out.println("Material used successfully.");
            System.out.println("Remaining Material Balance: " + materialBalance + " tons.");
        } else {
            System.out.println("Usage failed: Must keep at least 2 tons after usage.");
        }
    }

    @Override public void receiveMaterial() {}
    @Override public void estimateCost() {}
}
