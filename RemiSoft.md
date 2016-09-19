# PRODESO
Cambios en CCliente y CCuente de hoy 18092016
Apuntan a reflejar los siguiente conceptos:
* todo cliente tiene al menos 1 cuenta.
* con la creación de un CCliente automáticamente se crea una CCuenta en estado activa y con saldo máximo prefijado
* con la eliminacion de un CCliente automáticamente se elimina cada CCuenta activa pero si alguna CCuenta está bloqueada no se puede eliminar el CCliente
* un cliente puede tener 1+ cuentas
* en tanto no se cierre una CCuenta puede tener 2 estados: activa o bloqueada
* una cuenta está activa en tanto su saldo no supere un importe máximo prefijado
* una cuenta está bloqueada en tanto su saldo es igual o supera un importe máximo prefijado
* una cuenta se desbloquea y vuelve a estar activa si su saldo es menor a un importe máximo prefijado
* bloqueo y desbloqueo son automáticos. acá la decisión pasa por si la automaticidad se logra mejor con métodos de CCliente o de CCuenta. en la versión de hoy son métodos de CCliente


