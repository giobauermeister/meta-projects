DESCRIPTION = "This recipe installs the Airport Dual Display Demo - Kiosk"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

SRC_URI = "git://github.com/giobauermeister/qt-airport-kiosk-demo.git;protocol=git;branch=master \
		  "

SRCREV = "203e91490ec3d2112833f314f5faa488bc90b90d"

S = "${WORKDIR}/git"

inherit systemd

DEPENDS = "qtdeclarative qtgraphicaleffects"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

require recipes-qt/qt5/qt5.inc

do_install() {
		oe_runmake INSTALL_ROOT=${D} install

		install -m 0755 ${WORKDIR}/git/qt-airport-kiosk-demo.sh ${D}${bindir}

		install -d ${D}${systemd_unitdir}/system/	
		install -m 0644 ${WORKDIR}/git/qt-airport-kiosk-demo.service ${D}${systemd_unitdir}/system
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "qt-airport-kiosk-demo.service"
