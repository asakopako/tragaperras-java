# Tragaperras

1. Queremos implementar el software que simula el funcionamiento de las máquinas tragaperras. A continuación se describen los requisitos de la aplicación.
   - Una máquina tragaperras se caracteriza por un número fijo de casillas que utiliza para formar la combinación. En cada casilla se mostrará una fruta que puede ser fresa, sandía, plátano, melocotón o pera.
   - La máquina también tiene una recaudación, que corresponde con la cantidad de dinero que contiene. Se puede crear la máquina con una recaudación inicial para dar premios. La recaudación se irá incrementando con las jugadas de los usuarios y se reducirá cuando se concedan premios.
   - Cada máquina gestiona el conjunto de premios que puede dar (altas y bajas). Cada premio consiste en una combinación concreta de frutas a la que le corresponde una cantidad fija de dinero. Nótese que el número de frutas de la combinación dependerá de la máquina tragaperras en la que se va a registrar dicho premio. Por tanto, en una máquina sólo podrán registrarse aquellos premios cuyo tamaño de la combinación coincida con el número de casillas de dicha máquina.
   - El precio de una jugada es fijo para cada máquina. Se puede jugar si el crédito disponible en la máquina es igual o superior al coste de la jugada. El crédito puede incrementarse explícitamente y también se incrementará implícitamente cada vez que se consiga un premio.
   - En cualquier momento se puede cobrar la cantidad acumulada en premios, es decir, el crédito disponible.
   - En cada jugada se generará aleatoriamente una combinación de frutas del tamaño de la combinación fijado en la máquina y se comprobará si: a) dicha combinación tiene premio (es decir, se encuentra entre los premios registrados), b) el premio a conceder es menor o igual que la recaudación y c) el premio es aceptado. De ser así se incrementará el crédito disponible.
   - La máquina no concede los premios de forma automática, sino que dicha concesión depende del histórico de premios dados. Para ello podrá ser configurada con distintos modos de aceptación de premios. La máquina siempre debe tener un modo de aceptación.
   - La concesión o no de un premio dependerá del modo de aceptación de premios establecido. Por ejemplo, un modo "conservador" evita dar un mismo premio dos veces seguidas y el modo "ganancia" no permite que la suma de la cantidad concedida en los últimos 10 premios (incluido el premio actual) sea mayor que una cierta cantidad, como por ejemplo 200 euros.
   
2. Implementa el código que recoja todos los requisitos descritos aplicando la técnica de Diseño por Contrato. Implementa también el modo de aceptación de premios “ganancia”.

3. Escribe un programa que cree una máquina con un tamaño de combinación de 3 frutas y un precio por partida de 0,25 euros. Configura la máquina con el modo “ganancia” con límite 150 euros. Establece en esa máquina dos premios: (fresa, fresa, fresa) con 20 euros y (sandía, fresa, sandía) con 10 euros. Inicialmente la máquina tiene una recaudación de 200 euros. Se introducirá un crédito de 30 euros en la máquina y se jugará mientras quede crédito disponible. Tras cada jugada se mostrará el crédito disponible.