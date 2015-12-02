DESCRIPTION = "Essa aplicação faz parte do artigo para o embarcados"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

SRC_URI = "git://github.com/giobauermeister/app-artigo-screen1.git;protocol=git;branch=master \
		  "

SRCREV = "e1200176d801393cda662ca60552c94a2b023b33"

S = "${WORKDIR}/git"

inherit systemd

DEPENDS = "qtdeclarative qtgraphicaleffects"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

require recipes-qt/qt5/qt5.inc

do_install() {
		oe_runmake INSTALL_ROOT=${D} install
		#install -d ${D}${bindir}
        #chmod +x ${D}${bindir}/screen1

		install -m 0755 ${WORKDIR}/git/qt-artigo-embarcados-screen1.sh ${D}${bindir}
		#chmod +x ${D}${bindir}/qt-artigo-embarcados-screen1.sh

		install -d ${D}${systemd_unitdir}/system/	
		install -m 0644 ${WORKDIR}/git/qt-artigo-embarcados-screen1.service ${D}${systemd_unitdir}/system
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "qt-artigo-embarcados-screen1.service"
