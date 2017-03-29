inherit base
FILESEXTRAPATHS_append := "${THISDIR}/files"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.broadcom_brcm80211;md5=f60c122b4e8350839f9173c8dd7f2ef9"

SRC_URI = "\
    file://LICENSE.broadcom \
    file://LICENSE.broadcom_brcm80211 \
    file://bcm43438a0.hcd \
    file://bcm43438a1.hcd \
    file://brcmfmac43430-sdio.bin \
    file://brcmfmac43430-sdio.txt \
    file://config.txt \
    file://fw_bcm43438a0_apsta.bin \
    file://fw_bcm43438a0.bin \
    file://fw_bcm43438a0_p2p.bin \
    file://fw_bcm43438a1_apsta.bin \
    file://fw_bcm43438a1.bin \
    file://fw_bcm43438a1_p2p.bin \
    file://nvram_ap6212.txt \
    file://nvram.txt \
    "

FILES_${PN} = "/lib/firmware/ap6212"

do_install_append() {
    mkdir -p ${D}/lib/firmware/ap6212
    cp ${WORKDIR}/bcm43438a0.hcd ${D}/lib/firmware/ap6212/bcm43438a0.hcd
    cp ${WORKDIR}/bcm43438a1.hcd ${D}/lib/firmware/ap6212/bcm43438a1.hcd
    cp ${WORKDIR}/brcmfmac43430-sdio.bin ${D}/lib/firmware/ap6212/brcmfmac43430-sdio.bin
    cp ${WORKDIR}/brcmfmac43430-sdio.txt ${D}/lib/firmware/ap6212/brcmfmac43430-sdio.txt
    cp ${WORKDIR}/config.txt ${D}/lib/firmware/ap6212/config.txt
    cp ${WORKDIR}/fw_bcm43438a0_apsta.bin ${D}/lib/firmware/ap6212/fw_bcm43438a0_apsta.bin
    cp ${WORKDIR}/fw_bcm43438a0.bin ${D}/lib/firmware/ap6212/fw_bcm43438a0.bin
    cp ${WORKDIR}/fw_bcm43438a0_p2p.bin ${D}/lib/firmware/ap6212/fw_bcm43438a0_p2p.bin
    cp ${WORKDIR}/fw_bcm43438a1_apsta.bin ${D}/lib/firmware/ap6212/fw_bcm43438a1_apsta.bin
    cp ${WORKDIR}/fw_bcm43438a1.bin ${D}/lib/firmware/ap6212/fw_bcm43438a1.bin
    cp ${WORKDIR}/fw_bcm43438a1_p2p.bin ${D}/lib/firmware/ap6212/fw_bcm43438a1_p2p.bin
    cp ${WORKDIR}/nvram_ap6212.txt ${D}/lib/firmware/ap6212/nvram_ap6212.txt
    cp ${WORKDIR}/nvram.txt ${D}/lib/firmware/ap6212/nvram.txt
}
