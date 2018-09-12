package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class RegistrationInstructionsMessage(registIDField:RegistIDField,
                                           registTransTypeField:RegistTransTypeField,
                                           registRefIDField:RegistRefIDField,
                                           clOrdIDField:Option[ClOrdIDField]=None,
                                           partiesComponent:Option[PartiesComponent]=None,
                                           accountField:Option[AccountField]=None,
                                           acctIDSourceField:Option[AcctIDSourceField]=None,
                                           registAcctTypeField:Option[RegistAcctTypeField]=None,
                                           taxAdvantageTypeField:Option[TaxAdvantageTypeField]=None,
                                           ownershipTypeField:Option[OwnershipTypeField]=None,
                                           rgstDtlsGrpComponent:Option[RgstDtlsGrpComponent]=None,
                                           rgstDistInstGrpComponent:Option[RgstDistInstGrpComponent]=None) extends SfFixMessageBody("o")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,registIDField)
    fmt(b,registTransTypeField)
    fmt(b,registRefIDField)
    clOrdIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    registAcctTypeField.foreach(fmt(b,_))
    taxAdvantageTypeField.foreach(fmt(b,_))
    ownershipTypeField.foreach(fmt(b,_))
    rgstDtlsGrpComponent.foreach(fmt(b,_))
    rgstDistInstGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object RegistrationInstructionsMessage extends SfFixMessageDecoder {
  val MsgType="o"
  val MsgName="RegistrationInstructions"
             
  override val MandatoryFields = HashSet[Int](
    RegistIDField.TagId, RegistTransTypeField.TagId, RegistRefIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || RgstDtlsGrpComponent.isMandatoryField(tagId) || RgstDistInstGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ClOrdIDField.TagId, AccountField.TagId, AcctIDSourceField.TagId, RegistAcctTypeField.TagId, TaxAdvantageTypeField.TagId, 
    OwnershipTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || RgstDtlsGrpComponent.isOptionalField(tagId) || RgstDistInstGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || RgstDtlsGrpComponent.isFieldOf(tagId) || RgstDistInstGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RegistIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(RegistrationInstructionsMessage(RegistIDField.decode(myFields.get(RegistIDField.TagId)).get,
        RegistTransTypeField.decode(myFields.get(RegistTransTypeField.TagId)).get,
        RegistRefIDField.decode(myFields.get(RegistRefIDField.TagId)).get,
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(RegistAcctTypeField.TagId).flatMap(f=>RegistAcctTypeField.decode(f)),
        myFields.get(TaxAdvantageTypeField.TagId).flatMap(f=>TaxAdvantageTypeField.decode(f)),
        myFields.get(OwnershipTypeField.TagId).flatMap(f=>OwnershipTypeField.decode(f)),
        RgstDtlsGrpComponent.decode(flds, startPos),
        RgstDistInstGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     