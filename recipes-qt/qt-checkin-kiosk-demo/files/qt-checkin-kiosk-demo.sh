#!bin/bash
export QT_QPA_EGLFS_DISABLE_INPUT=1
export QT_QPA_EGLFS_HIDECURSOR=1
export QT_QPA_EGLFS_FB=/dev/fb0
flightKiosk -platform eglfs -plugin tslib:/dev/input/event0
export QT_QPA_EGLFS_FB=/dev/fb2
flighInfo -platform eglfs -plugin tslib:/dev/input/event0
