package pages.base;

import list_enums.OsList;
import org.openqa.selenium.WebElement;

public interface ActionsEmployee {
    public String copyLinkToDownload(WebElement element, OsList os);
    public AddEmployeePage deleteInvitation(WebElement employee);
    public AddEmployeePage sendInvitationAgain(WebElement employee);
}
