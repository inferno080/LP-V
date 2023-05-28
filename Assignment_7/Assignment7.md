# Steps to Follow :

## Installations [HUGE HEADACHE - DOESN'T WORK FOR EVERYONE]

```
sudo su
```

1. INSTALL NETBEANS:

```
sudo apt update
sudo snap install netbeans --classic
```

2. INSTALL GLASSFISH SERVER:

```
wget http://download.oracle.com/glassfish/5.0/release/glassfish-5.0.zip
unzip glassfish-5.0.zip -d /opt
chown -R root: /opt/glassfish5
```

3. CREATE SYSTEMD FILE:

```
sudo apt install vim
vim /etc/systemd/system/glassfish.service
```
*press 'i' to insert lines *

COPY PASTE FOLLOWING LINES IN THE FILE (ctrl + shift + v):
```
[Unit]
Description = GlassFish Server v5
After = syslog.target network.target

[Service]
User=root
ExecStart=/opt/glassfish5/bin/asadmin start-domain
ExecReload=/opt/glassfish5/bin/asadmin restart-domain
ExecStop=/opt/glassfish5/bin/asadmin stop-domain
Type = forking

[Install]
WantedBy = multi-user.target

*press 'esc' and then ':wq!' then 'enter' *

systemctl daemon-reload
systemctl start glassfish
```
## Assignment

Pray to all Gods that you have all installations done in actual practical exam
```https://www.youtube.com/watch?v=0z-HvSfr-M4```
