package com.testSuit;

import org.junit.Ignore;
import org.junit.Test;

import com.pages.AdminLogin;
import com.pages.BasePage;
import com.pages.DiscountPage;
import com.pages.EndScreenPage;
import com.pages.ExtendPage;
import com.pages.ExtrasPage;
import com.pages.LockersPage;
import com.pages.PasscodePage;
import com.pages.PaymentPage;
import com.pages.PlsEndRentalPage;
import com.pages.PlsPage;
import com.pages.WelcomePage;
import com.practice.SocktWPE;

import library.ReadGPXMLs;

public class SmokeTest extends BasePage {

	BasePage basePage = new BasePage();
	WelcomePage welcomePage = new WelcomePage();
	AdminLogin adminLogin = new AdminLogin();
	LockersPage lockersPage = new LockersPage();
	PaymentPage paymentPage = new PaymentPage();
	ExtrasPage extrasPage = new ExtrasPage();
	PasscodePage passcodePage = new PasscodePage();
	PlsPage plsPage = new PlsPage();
	EndScreenPage endScreenPage = new EndScreenPage();
	PlsEndRentalPage plsEndRentalPage = new PlsEndRentalPage();
	SocktWPE pt2 = new SocktWPE();
	ExtendPage extendPage = new ExtendPage();
	DiscountPage discountPage = new DiscountPage();
	ReadGPXMLs readxmls = new ReadGPXMLs();

	@Ignore
	@Test
	public void extendEXlocker() throws Exception {

		// start WPE listen socketID
		pt2.listenSocketID("");

		welcomePage.gotoWelcome();
		welcomePage.clickHomePage();
		plsPage.goOpenExpireLocker();
		extendPage.findExpireLocker(1, "1111");
		extendPage.ExtendHours();

		// get socket
		pt2.setSocketID(readxmls.setUpXml("", "processor"));
		pt2.playPacket_Service(readxmls.setUpXml("", "processor"));
		endScreenPage.finish();

		for (int i = 2; i < 29; i++) {
			ul.customWait(1);
			welcomePage.clickHomePage();
			plsPage.goOpenExpireLocker();
			extendPage.findExpireLocker(i, "1111");
			extendPage.ExtendHours();
			pt2.playPacket_Service(readxmls.setUpXml("", "processor"));
			endScreenPage.finish();

		}

	}

	@Test
	public void rentPLSTest() throws Exception {
		// paypros and rent PLS

		// start WPE listen socketID
		pt2.listenSocketID("");

		welcomePage.gotoWelcome();
		welcomePage.clickHomePage();
		plsPage.goPLSLocker();
		extrasPage.finishExtras();
		// get socket
		pt2.setSocketID("paypros");
		pt2.playPacket_Service("paypros");
		// cutomer ID
		plsPage.enterCustomerID();
		ul.customWait(1);
		endScreenPage.finish();
		ul.customWait(2);

		for (int i = 1111132; i < 1111142; i++) {

			// rent pls

			welcomePage.clickHomePage();
			plsPage.goPLSLocker();
			extrasPage.finishExtras();
			pt2.playPacket_Service("paypros");
			plsPage.enterCustomerID();
			ul.customWait(1);
			endScreenPage.finish();
			ul.customWait(1);
		}

		// sign admin, end both rental
		ul.customWait(1);
		welcomePage.logInAdmin();
		adminLogin.adminLogin("Su");
		adminLogin.getLockerStatus();
		adminLogin.typeLockers(null);
		adminLogin.logOutAdmin();

		for (int i = 1111131; i < 1111142; i++) {

			ul.customWait(1);
			welcomePage.clickHomePage();
			plsPage.goMovePLS();
			plsPage.enterCustomerID();
			plsEndRentalPage.confirmEndPLS();
			endScreenPage.finish();
		}

		for (int i = 13; i < 21; i++) {

			// rent pls

			welcomePage.clickHomePage();
			plsPage.goSingleLocker();
			if (i <= 12) {
				lockersPage.selectLockerSize("Standard");
			} else if (i > 12 && i < 17) {
				lockersPage.selectLockerSize("Large");
			} else {
				lockersPage.selectLockerSize("Jumbo");
			}
			extrasPage.finishExtras();
			pt2.playPacket_Service("paypros");
			passcodePage.passCode();
			endScreenPage.finish();
			ul.customWait(2);
		}

	}

	@Ignore
	@Test
	public void rentSignleEntry() throws Exception {
		// paypros and rent PLS

		// start WPE listen socketID
		pt2.listenSocketID("");

		welcomePage.gotoWelcome();
		welcomePage.clickHomePage();
		plsPage.goSingleLocker();
		lockersPage.selectLockerSize("Standard");
		extrasPage.finishExtras();
		// get socket
		pt2.setSocketID("paypros");
		pt2.playPacket_Service("paypros");
		// cutomer ID
		passcodePage.passCode();
		endScreenPage.finish();
		ul.customWait(2);

		for (int i = 13; i < 21; i++) {

			// rent pls

			welcomePage.clickHomePage();
			plsPage.goSingleLocker();
			if (i <= 12) {
				lockersPage.selectLockerSize("Standard");
			} else if (i > 12 && i < 17) {
				lockersPage.selectLockerSize("Large");
			} else {
				lockersPage.selectLockerSize("Jumbo");
			}
			extrasPage.finishExtras();
			pt2.playPacket_Service("paypros");
			passcodePage.passCode();
			endScreenPage.finish();
			ul.customWait(2);
		}
	}

	@Ignore
	@Test
	public void PLS_Paypros_Test() throws Exception {
		// paypros and rent PLS

		// start WPE listen socketID
		pt2.listenSocketID("");
		// go to payment page
		welcomePage.gotoWelcome();
		welcomePage.clickHomePage();
		plsPage.goPLSLocker();
		// get socket
		pt2.setSocketID("paypros");
		pt2.playPacket_Service("paypros");

	}

	@Ignore
	@Test
	public void MultiPLSTest() throws Exception {
		// issue coupon and rent PLS
		welcomePage.gotoWelcome();
		// wp.logInAdmin();
		// adp.adminLogin("2222", "4321");
		// adp.issueCoupon("5");
		// adp.logOutAdmin();
		// ul.customWait(1);
		// wp.clickHomePage();
		// plp.goPLSLocker();
		// exp.finishExtras();
		// pp.redeemCoupon(SQL_JDBC.coupon("3873"));
		// plp.enterCustomerID("1111111", "1111");
		// endp.finish();
		// // sign admin, end both
		// ul.customWait(1);
		// wp.logInAdmin();
		// adp.adminLogin("2222", "4321");
		// adp.getLockerStatus();
		// adp.endRental(null);
		// adp.logOutAdmin();
		// move
		for (int j = 0; j < 10; j++) {

			// move PLS two time
			for (int i = 0; i < 2; i++) {

				ul.customWait(1);
				welcomePage.clickHomePage();
				plsPage.goMovePLS();
				plsPage.enterCustomerID();
				plsEndRentalPage.confirmEndPLS();
				endScreenPage.finish();
			}
			// sign admin, end both rental
			ul.customWait(1);
			welcomePage.logInAdmin();
			adminLogin.adminLogin("Su");
			adminLogin.getLockerStatus();
			adminLogin.typeLockers(null);
			adminLogin.logOutAdmin();

			// move PLS one time
			ul.customWait(1);
			welcomePage.clickHomePage();
			plsPage.goMovePLS();
			plsPage.enterCustomerID();
			plsEndRentalPage.confirmEndPLS();
			endScreenPage.finish();

			// sign admin, end one
			ul.customWait(1);
			welcomePage.logInAdmin();
			adminLogin.adminLogin("Su");
			adminLogin.getLockerStatus();
			adminLogin.typeLockers(null);
			adminLogin.logOutAdmin();

		}
	}

	@Ignore
	@Test
	public void RentLockerJumbo() throws Exception {
		welcomePage.gotoWelcome();
		// coupon

		for (int i = 0; i < 4; i++) {

			//
			// wp.logInAdmin();
			// adp.adminLogin("2222", "4321");
			// adp.issueCoupon("12");
			// adp.logOutAdmin();
			// ul.customWait(1);

			welcomePage.clickHomePage();
			lockersPage.selectLockerSize("Large");
			lockersPage.agreePriceTC();
			extrasPage.finishExtras();

			paymentPage.agreeTermCondition();

			paymentPage.redeemCoupon("");
			passcodePage.passCode();
		}
	}

	@Ignore
	@Test
	public void RentDiscountLockerWithRFID() throws Exception {
		welcomePage.gotoWelcome();
		// start WPE listen socketID for scan and rfid
		pt2.listenSocketID("");

		welcomePage.clickHomePage();
		discountPage.goGeneralDiscount();
		// get scan socket and play
		pt2.setSocketID("scan");
		pt2.playPacket_Service("scan");

		// select locker
		pt2.listenSocketID("");
		lockersPage.selectLockerSize("Standard");
		lockersPage.agreePriceTC();
		extrasPage.finishExtras();
		paymentPage.agreeTermCondition();

		pt2.setSocketID("rfid");
		pt2.playPacket_Service("rfid");
		passcodePage.passCode();
		endScreenPage.finish();

		for (int i = 0; i < 5; i++) {
			ul.customWait(1);
			welcomePage.clickHomePage();
			discountPage.goGeneralDiscount();
			pt2.playPacket_Service("scan");
			if (i == 1) {
				lockersPage.selectLockerSize("Large");
			} else if (i == 2) {
				lockersPage.selectLockerSize("Jumbo");
			} else {
				lockersPage.selectLockerSize("Standard");
			}

			lockersPage.agreePriceTC();
			extrasPage.finishExtras();
			paymentPage.agreeTermCondition();

			pt2.playPacket_Service("rfid");
			passcodePage.passCode();
			endScreenPage.finish();

		}

	}

	@Ignore
	@Test
	public void RentAllSingleLocker() throws Exception {

		welcomePage.gotoWelcome();
		// start WPE listen socketID for scan and rfid
		pt2.listenSocketID("");
		welcomePage.clickHomePage();

		plsPage.goSingleLocker();

		lockersPage.selectLockerSize("Standard");

		lockersPage.agreePriceTC();
		extrasPage.finishExtras();
		paymentPage.agreeTermCondition();

		pt2.setSocketID("paypros");
		pt2.playPacket_Service("paypros");

		passcodePage.passCode();
		endScreenPage.finish();

		for (int i = 2; i < 21; i++) {
			ul.customWait(1);
			welcomePage.clickHomePage();

			plsPage.goSingleLocker();

			if (i <= 10) {

				lockersPage.selectLockerSize("Standard");
			}

			else if (i > 10 && i < 18) {
				lockersPage.selectLockerSize("Large");
			}

			else {
				lockersPage.selectLockerSize("Jumbo");
			}

			lockersPage.agreePriceTC();
			extrasPage.finishExtras();
			paymentPage.agreeTermCondition();

			pt2.playPacket_Service("paypros");

			passcodePage.passCode();
			endScreenPage.finish();

		}

		// sign admin, end all rental
		ul.customWait(1);
		welcomePage.logInAdmin();
		adminLogin.adminLogin("Su");
		adminLogin.getLockerStatus();
		adminLogin.typeLockers(null);
		adminLogin.logOutAdmin();

		ul.customWait(1);
		// PLS
		welcomePage.clickHomePage();
		plsPage.goPLSLocker();
		// get socket
		pt2.setSocketID("rfid");
		pt2.playPacket_Service("rfid");
		// cutomer ID
		plsPage.enterCustomerID();
		endScreenPage.finish();
		ul.customWait(2);

		for (int i = 1111190; i < 1111200; i++) {

			// rent pls

			welcomePage.clickHomePage();
			plsPage.goPLSLocker();
			pt2.playPacket_Service("rfid");
			plsPage.enterCustomerID();
			endScreenPage.finish();
			ul.customWait(2);
		}

		// sign admin, end all rental
		ul.customWait(1);
		welcomePage.logInAdmin();
		adminLogin.adminLogin("Su");
		adminLogin.getLockerStatus();
		adminLogin.typeLockers(null);
		adminLogin.logOutAdmin();

	}

	@Ignore
	@Test
	public void RentADASingleLocker() throws Exception {
		welcomePage.gotoWelcome();
		// start WPE listen socketID for scan and rfid
		pt2.listenSocketID("");
		welcomePage.clickHomePage();
		plsPage.selectADA();
		plsPage.goSingleLocker();

		lockersPage.selectLockerSize("Standard");

		lockersPage.agreePriceTC();
		// exp.finishExtras();
		paymentPage.agreeTermCondition();

		pt2.setSocketID("rfid");
		pt2.playPacket_Service("rfid");

		passcodePage.passCode();
		endScreenPage.finish();

		for (int i = 2; i < 21; i++) {
			ul.customWait(1);
			welcomePage.clickHomePage();
			plsPage.selectADA();
			plsPage.goSingleLocker();

			if (i <= 10) {

				lockersPage.selectLockerSize("Standard");
			}

			else if (i > 10 && i < 18) {
				lockersPage.selectLockerSize("Large");
			}

			else {
				lockersPage.selectLockerSize("Jumbo");
			}

			lockersPage.agreePriceTC();
			// exp.finishExtras();
			paymentPage.agreeTermCondition();

			pt2.playPacket_Service("rfid");

			passcodePage.passCode();
			endScreenPage.finish();

		}

	}

	@Ignore
	@Test
	public void Rent500LOcker() throws Exception {
		welcomePage.gotoWelcome();
		for (int i = 1; i < 500; i++) {
			ul.customWait(1);
			welcomePage.clickHomePage();
			lockersPage.selectLockerSize("Standard");
			lockersPage.agreePriceTC();
			extrasPage.finishExtras();
			passcodePage.passCode();
			endScreenPage.finish();
		}

	}

	@Ignore
	@Test
	public void RentDiscountLocker() throws Exception {
		welcomePage.gotoWelcome();
		// start WPE listen socketID

		welcomePage.logInAdmin();
		adminLogin.adminLogin("Su");
		adminLogin.issueCoupon(2);
		adminLogin.logOutAdmin();
		ul.customWait(1);

		pt2.listenSocketID("");

		welcomePage.clickHomePage();
		discountPage.goGeneralDiscount();

		// get socket
		pt2.setSocketID("scan");
		pt2.playPacket_Service("scan");

		// select locker
		lockersPage.selectLockerSize("Standard");
		lockersPage.agreePriceTC();
		extrasPage.finishExtras();

		paymentPage.agreeTermCondition();

		paymentPage.redeemCoupon("");
		passcodePage.passCode();
		endScreenPage.finish();

		for (int i = 0; i < 7; i++) {

			welcomePage.logInAdmin();
			adminLogin.adminLogin("Su");
			adminLogin.issueCoupon(2);
			adminLogin.logOutAdmin();
			ul.customWait(1);

			welcomePage.clickHomePage();
			discountPage.goGeneralDiscount();

			pt2.playPacket_Service("scan");

			// select locker
			lockersPage.selectLockerSize("Standard");
			lockersPage.agreePriceTC();
			extrasPage.finishExtras();

			paymentPage.agreeTermCondition();

			paymentPage.redeemCoupon("");
			passcodePage.passCode();
			endScreenPage.finish();

		}

		for (int j = 0; j < 7; j++) {

			welcomePage.logInAdmin();
			adminLogin.adminLogin("Su");
			adminLogin.issueCoupon(3);
			adminLogin.logOutAdmin();
			ul.customWait(1);

			welcomePage.clickHomePage();
			discountPage.goGeneralDiscount();

			pt2.playPacket_Service("scan");

			// select locker
			lockersPage.selectLockerSize("Large");
			lockersPage.agreePriceTC();
			extrasPage.finishExtras();

			paymentPage.agreeTermCondition();

			paymentPage.redeemCoupon("");
			passcodePage.passCode();
			endScreenPage.finish();

		}

	}

	@Ignore
	@Test
	public void IncreasedKioskAdminUser() throws Exception {

		welcomePage.gotoWelcome();
		// start WPE listen socketID

		welcomePage.logInAdmin();
		adminLogin.adminLogin("di");

		adminLogin.createAdminUser(200);

	}

	@Test
	public void ContinuesTimedPLSTestSuit() throws Exception {
		// paypros and rent PLS

		// start WPE listen socketID
		pt2.listenSocketID("");

		welcomePage.gotoWelcome();
		welcomePage.clickHomePage();

	}

}
