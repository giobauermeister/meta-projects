SUMMARY = "Qt5 technology demo"
DESCRIPTION = "Qt 5 Application, Checkin Kiosk Demo"
HOMEPAGE = "http://quitcoding.com/?page=work#cinex"
LICENSE = "CC-BY-3.0"
LIC_FILES_CHKSUM = "file://README.md;md5=0fdeae5336406cc73801a863f6834b5e"

SRC_URI = "git://github.com/giobauermeister/qt-flight-information-demo.git;protocol=git;branch=master \
		  "

SRCREV = "aa85d7078cf775a99eddb568f446a0eb5c2e9cf7"

S = "${WORKDIR}/git"

DEPENDS = "qtdeclarative qtgraphicaleffects"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

require recipes-qt/qt5/qt5.inc

do_install() {
	oe_runmake INSTALL_ROOT=${D} install
	install -d ${D}${bindir}
    chmod +x ${D}${bindir}/flighInfo
}


