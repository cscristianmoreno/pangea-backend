CREATE OR REPLACE FUNCTION fn_insertRoleAfterUser() RETURNS trigger AS $$
	DECLARE	
		result RECORD;
	BEGIN
		-- Por el moemnto no hace nada hasta ver si existe un rol por defecto.

		RETURN new;
	END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER tr_insertRoleAfterUser 
AFTER INSERT ON users
FOR EACH ROW
EXECUTE FUNCTION fn_insertRoleAfterUser();