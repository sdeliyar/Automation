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
import com.pages.PlsEndRentalPage;
import com.pages.PlsPage;
import com.pages.WelcomePage;
import com.pages.paymentPage;
import com.practice.SocktWPE;

import library.SQL_JDBC;

public class SmokeTest extends BasePage {

	BasePage basePage = new BasePage();
	WelcomePage wp = new WelcomePage();
	AdminLogin adp = new AdminLogin();
	LockersPage lp = new LockersPage();
	paymentPage pp = new paymentPage();
	ExtrasPage exp = new ExtrasPage();
	PasscodePage pcp = new PasscodePage();
	PlsPage plp = new PlsPage();
	EndScreenPage endp = new EndScreenPage();
	PlsEndRentalPage pendp = new PlsEndRentalPage();
	SocktWPE pt2 = new SocktWPE();
	ExtendPage extendPage = new ExtendPage();
	DiscountPage discountPage = new DiscountPage();
	@Ignore
	@Test
	public void extendEXlocker() throws Exception {

		// start WPE listen socketID
		pt2.listenSocketID("paypros");

		wp.gotoWelcome();
		wp.clickHomePage();
		plp.goOpenExpireLocker();
		extendPage.findExpireLocker(1, "1111");
		extendPage.ExtendHours();

		// get socket
		pt2.setSocketID("paypros");
		pt2.playPacket_Paypros("paypros");
		endp.finish();

		for (int i = 2; i < 29; i++) {
			ul.customWait(1);
			wp.clickHomePage();
			plp.goOpenExpireLocker();
			extendPage.findExpireLocker(i, "1111");
			extendPage.ExtendHours();
			pt2.playPacket_Paypros("paypros");
			endp.finish();

		}

	}

	@Ignore
	@Test
	public void rentPLSTest() throws Exception {
		// paypros and rent PLS

		// start WPE listen socketID
		pt2.listenSocketID("paypros");

		wp.gotoWelcome();
		wp.clickHomePage();
		plp.goPLSLocker();
		// get socket
		pt2.setSocketID("paypros");
		pt2.playPacket_Paypros("paypros");
		// cutomer ID
		plp.enterCustomerID("7777890", "1111");
		endp.finish();
		ul.customWait(2);

		for (int i = 1111190; i < 1111209; i++) {

			// rent pls

			wp.clickHomePage();
			plp.goPLSLocker();
			pt2.playPacket_Paypros("paypros");
			plp.enterCustomerID(Integer.toString(i), "1111");
			endp.finish();
			ul.customWait(2);
		}
	}

	@Ignore
	@Test
	public void PLS_Paypros_Test() throws Exception {
		// paypros and rent PLS

		// start WPE listen socketID
		pt2.listenSocketID("paypros");
		// go to payment page
		wp.gotoWelcome();
		wp.clickHomePage();
		plp.goPLSLocker();
		// get socket
		pt2.setSocketID("paypros");
		pt2.playPacket_Paypros("paypros");

	}

	@Ignore
	@Test
	public void MultiPLSTest() throws Exception {
		// issue coupon and rent PLS
		wp.gotoWelcome();
		// wp.logInAdmin();
		// adp.adminLogin("2222", "2222");
		// adp.issueCoupon("5");
		// adp.logOutAdmin();
		// ul.customWait(1);
		// wp.clickHomePage();
		// plp.goPLSLocker();
		// pp.redeemCoupon(SQL_JDBC.coupon("3892"));
		// plp.enterCustomerID("1111114", "1111");
		// endp.finish();
		// // sign admin, end both
		// ul.customWait(1);
		// wp.logInAdmin();
		// adp.adminLogin("2222", "2222");
		// adp.getLockerStatus();
		// adp.endRental(null);
		// adp.logOutAdmin();
		// move
		for (int j = 0; j < 10; j++) {

			// move PLS two time
			for (int i = 0; i < 2; i++) {

				ul.customWait(1);
				wp.clickHomePage();
				plp.goMovePLS();
				plp.enterCustomerID("1111114", "1111");
				pendp.confirmEndPLS();
				endp.finish();
			}
			// sign admin, end both rental
			ul.customWait(1);
			wp.logInAdmin();
			adp.adminLogin("2222", "2222");
			adp.getLockerStatus();
			adp.endRental(null);
			adp.logOutAdmin();

			// move PLS one time
			ul.customWait(1);
			wp.clickHomePage();
			plp.goMovePLS();
			plp.enterCustomerID("1111114", "1111");
			pendp.confirmEndPLS();
			endp.finish();

			// sign admin, end one
			ul.customWait(1);
			wp.logInAdmin();
			adp.adminLogin("2222", "2222");
			adp.getLockerStatus();
			adp.endRental(null);
			adp.logOutAdmin();

		}
	}

	@Ignore
	@Test
	public void RentLockerJumbo() throws Exception {
		wp.gotoWelcome();
		// coupon

		for (int i = 0; i < 4; i++) {

			//
			// wp.logInAdmin();
			// adp.adminLogin("2222", "4321");
			// adp.issueCoupon("12");
			// adp.logOutAdmin();
			// ul.customWait(1);

			wp.clickHomePage();
			lp.selectLockerSize("Large");
			lp.agreePriceTC();
			exp.finishExtras();

			pp.agreeTermCondition();

			pp.redeemCoupon(SQL_JDBC.coupon("3865"));
			pcp.passCode("1111");
		}
	}

	@Ignore
	@Test
	public void RentDiscountLockerWithRFID() throws Exception {
		wp.gotoWelcome();
		// start WPE listen socketID for scan and rfid
		pt2.listenSocketID("scan");

		wp.clickHomePage();
		discountPage.goGeneralDiscount();
		// get scan socket and play
		pt2.setSocketID("scan");
		pt2.playPacket_Paypros("scan");

		// select locker
		pt2.listenSocketID("rfid");
		lp.selectLockerSize("Standard");
		lp.agreePriceTC();
		exp.finishExtras();
		pp.agreeTermCondition();

		pt2.setSocketID("rfid");
		pt2.playPacket_Paypros("rfid");
		pcp.passCode("1111");
		endp.finish();

		for (int i = 0; i < 5; i++) {
			ul.customWait(1);
			wp.clickHomePage();
			discountPage.goGeneralDiscount();
			pt2.playPacket_Paypros("scan");
			if (i == 1) {
				lp.selectLockerSize("Large");
			} else if (i == 2) {
				lp.selectLockerSize("Jumbo");
			} else {
				lp.selectLockerSize("Standard");
			}

			lp.agreePriceTC();
			exp.finishExtras();
			pp.agreeTermCondition();

			pt2.playPacket_Paypros("rfid");
			pcp.passCode("1111");
			endp.finish();

		}

	}

	@Ignore
	@Test
	public void RentAllSingleLocker() throws Exception {

		wp.gotoWelcome();
		// start WPE listen socketID for scan and rfid
		pt2.listenSocketID("paypros");
		wp.clickHomePage();

		plp.goSingleLocker();

		lp.selectLockerSize("Standard");

		lp.agreePriceTC();
		exp.finishExtras();
		pp.agreeTermCondition();

		pt2.setSocketID("paypros");
		pt2.playPacket_Paypros("paypros");

		pcp.passCode("1111");
		endp.finish();

		for (int i = 2; i < 21; i++) {
			ul.customWait(1);
			wp.clickHomePage();

			plp.goSingleLocker();

			if (i <= 10) {

				lp.selectLockerSize("Standard");
			}

			else if (i > 10 && i < 18) {
				lp.selectLockerSize("Large");
			}

			else {
				lp.selectLockerSize("Jumbo");
			}

			lp.agreePriceTC();
			exp.finishExtras();
			pp.agreeTermCondition();

			pt2.playPacket_Paypros("paypros");

			pcp.passCode("1111");
			endp.finish();

		}

		// sign admin, end all rental
		ul.customWait(1);
		wp.logInAdmin();
		adp.adminLogin("2222", "2222");
		adp.getLockerStatus();
		adp.endRental(null);
		adp.logOutAdmin();

		ul.customWait(1);
		// PLS
		wp.clickHomePage();
		plp.goPLSLocker();
		// get socket
		pt2.setSocketID("rfid");
		pt2.playPacket_Paypros("rfid");
		// cutomer ID
		plp.enterCustomerID("7777890", "1111");
		endp.finish();
		ul.customWait(2);

		for (int i = 1111190; i < 1111200; i++) {

			// rent pls

			wp.clickHomePage();
			plp.goPLSLocker();
			pt2.playPacket_Paypros("rfid");
			plp.enterCustomerID(Integer.toString(i), "1111");
			endp.finish();
			ul.customWait(2);
		}

		// sign admin, end all rental
		ul.customWait(1);
		wp.logInAdmin();
		adp.adminLogin("2222", "2222");
		adp.getLockerStatus();
		adp.endRental(null);
		adp.logOutAdmin();

	}

	@Ignore
	@Test
	public void RentADASingleLocker() throws Exception {
		wp.gotoWelcome();
		// start WPE listen socketID for scan and rfid
		pt2.listenSocketID("rfid");
		wp.clickHomePage();
		plp.selectADA();
		plp.goSingleLocker();

		lp.selectLockerSize("Standard");

		lp.agreePriceTC();
		// exp.finishExtras();
		pp.agreeTermCondition();

		pt2.setSocketID("rfid");
		pt2.playPacket_Paypros("rfid");

		pcp.passCode("1111");
		endp.finish();

		for (int i = 2; i < 21; i++) {
			ul.customWait(1);
			wp.clickHomePage();
			plp.selectADA();
			plp.goSingleLocker();

			if (i <= 10) {

				lp.selectLockerSize("Standard");
			}

			else if (i > 10 && i < 18) {
				lp.selectLockerSize("Large");
			}

			else {
				lp.selectLockerSize("Jumbo");
			}

			lp.agreePriceTC();
			// exp.finishExtras();
			pp.agreeTermCondition();

			pt2.playPacket_Paypros("rfid");

			pcp.passCode("1111");
			endp.finish();

		}

	}

	@Ignore
	@Test
	public void Rent500LOcker() throws Exception {
		wp.gotoWelcome();
		for (int i = 1; i < 500; i++) {
			ul.customWait(1);
			wp.clickHomePage();
			lp.selectLockerSize("Standard");
			lp.agreePriceTC();
			exp.finishExtras();
			pcp.passCode("1111");
			endp.finish();
		}

	}

	@Ignore
	@Test
	public void RentDiscountLocker() throws Exception {
		wp.gotoWelcome();
		// start WPE listen socketID

		wp.logInAdmin();
		adp.adminLogin("3333", "3333");
		adp.issueCoupon("7");
		adp.logOutAdmin();
		ul.customWait(1);

		pt2.listenSocketID("scan");

		wp.clickHomePage();
		discountPage.goGeneralDiscount();

		// get socket
		pt2.setSocketID("scan");
		pt2.playPacket_Paypros("scan");

		// select locker
		lp.selectLockerSize("Standard");
		lp.agreePriceTC();
		exp.finishExtras();

		pp.agreeTermCondition();

		pp.redeemCoupon(SQL_JDBC.coupon("3892"));
		pcp.passCode("1111");
		endp.finish();

		for (int i = 0; i < 7; i++) {

			wp.logInAdmin();
			adp.adminLogin("3333", "3333");
			adp.issueCoupon("7");
			adp.logOutAdmin();
			ul.customWait(1);

			wp.clickHomePage();
			discountPage.goGeneralDiscount();

			pt2.playPacket_Paypros("scan");

			// select locker
			lp.selectLockerSize("Standard");
			lp.agreePriceTC();
			exp.finishExtras();

			pp.agreeTermCondition();

			pp.redeemCoupon(SQL_JDBC.coupon("3892"));
			pcp.passCode("1111");
			endp.finish();

		}

		for (int j = 0; j < 7; j++) {

			wp.logInAdmin();
			adp.adminLogin("3333", "3333");
			adp.issueCoupon("10");
			adp.logOutAdmin();
			ul.customWait(1);

			wp.clickHomePage();
			discountPage.goGeneralDiscount();

			pt2.playPacket_Paypros("scan");

			// select locker
			lp.selectLockerSize("Large");
			lp.agreePriceTC();
			exp.finishExtras();

			pp.agreeTermCondition();

			pp.redeemCoupon(SQL_JDBC.coupon("3892"));
			pcp.passCode("1111");
			endp.finish();

		}

	}

	@Ignore
	@Test
	public void IncreasedKioskAdminUser() throws Exception {

		wp.gotoWelcome();
		// start WPE listen socketID

		wp.logInAdmin();
		adp.adminLogin("4567", "4321");

		adp.createAdminUser(200);

	}
}
