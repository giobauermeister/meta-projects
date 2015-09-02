SUMMARY = "Qt5 technology demo"
DESCRIPTION = "Qt 5 Application, Checkin Kiosk Demo"
HOMEPAGE = "http://quitcoding.com/?page=work#cinex"
LICENSE = "CC-BY-3.0"
LIC_FILES_CHKSUM = "file://README.md;md5=fc549ad41e0018be709dda7b7b983292"

SRC_URI = 	"git://github.com/giobauermeister/qt-checkin-kiosk-demo.git;protocol=git;branch=master \		
			 file://qt-checkin-kiosk-demo.service \
			 file://qt-checkin-kiosk-demo.sh \			
			"

SRCREV = "1dc24d8f3329d340e5152a7d820ea31c961493a2"

S = "${WORKDIR}/git"

inherit systemd

DEPENDS = "qtdeclarative qtgraphicaleffects"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

require recipes-qt/qt5/qt5.inc

do_install() {
	oe_runmake INSTALL_ROOT=${D} install

	install -d ${D}${bindir}
    chmod +x ${D}${bindir}/flightKiosk

    install -m 0755 ${WORKDIR}/git/qt-checkin-kiosk-demo.sh ${D}${bindir}
	chmod +x ${D}${bindir}/qt-checkin-kiosk-demo.sh

    install -d ${D}${systemd_unitdir}/system/	
	install -m 0644 ${WORKDIR}/git/qt-checkin-kiosk-demo.service ${D}${systemd_unitdir}/system
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "qt-checkin-kiosk-demo.service"
