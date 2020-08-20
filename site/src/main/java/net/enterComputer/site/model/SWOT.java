package net.enterComputer.site.model;

import javax.persistence.*;

@Entity(name = "swot")
public class SWOT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String strength;
    private String opportunity;
    private String weakness;
    private String threat;

    public SWOT() {
    }

    public SWOT(Long id, String strength, String opportunity, String weakness, String threat) {
        this.id = id;
        this.strength = strength;
        this.opportunity = opportunity;
        this.weakness = weakness;
        this.threat = threat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getThreat() {
        return threat;
    }

    public void setThreat(String threat) {
        this.threat = threat;
    }
}
