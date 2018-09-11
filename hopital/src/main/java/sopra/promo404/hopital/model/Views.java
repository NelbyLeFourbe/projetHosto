package sopra.promo404.hopital.model;

public class Views {
	public static class ViewCommon {
	}

	public static class ViewSecretaire extends ViewCommon {
	}

	public static class ViewFileAttente extends ViewCommon {
	}

	public static class ViewMedecin extends ViewCommon {
	}

	public static class ViewMedecinWithSpecialite extends ViewMedecin {
	}
	public static class ViewPatient extends ViewCommon {
	}
	public static class ViewConsultation extends ViewCommon {
	}
	public static class ViewPatientWithConsultations extends ViewCommon {
	}
	

	public static class ViewSpecialite extends ViewCommon {
	}

	public static class ViewSpecialiteWithConsultation extends ViewSpecialite {
	}

	public static class ViewSecretaireWithFileAttente extends ViewSecretaire {
	}
	
	public static class ViewFileAttenteWithSecretaire extends ViewFileAttente {
	}
}
