DESCRIPTION = "Essa aplicação faz parte do artigo para o embarcados"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

SRC_URI = "git://github.com/giobauermeister/app-artigo-screen2.git;protocol=git;branch=master \
		  "

SRCREV = "012d0ae0a5e093ae4d46cd5ea89131c8b9d59527"

S = "${WORKDIR}/git"

DEPENDS = "qtdeclarative qtgraphicaleffects"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

require recipes-qt/qt5/qt5.inc

do_install() {
		oe_runmake INSTALL_ROOT=${D} install
		#install -d ${D}${bindir}
        #chmod +x ${D}${bindir}/screen2
}
