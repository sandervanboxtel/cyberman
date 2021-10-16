module waterworld {
    requires hanyaeger;

    exports nl.hanyeager.sander;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports nl.hanyeager.sander.entities;
}
