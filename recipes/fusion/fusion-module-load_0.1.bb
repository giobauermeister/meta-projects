DESCRIPTION = "This recipe copies a conf file to load fusion display module"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

SRC_URI = "file://fusion.conf"

do_install() {
	install -d ${D}/${sysconfdir}/modules-load.d
	install -m 0644 ${WORKDIR}/fusion.conf ${D}/${sysconfdir}/modules-load.d/
}
