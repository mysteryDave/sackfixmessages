package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class DerivativeSecurityListMessage(securityReqIDField:SecurityReqIDField,
                                         securityResponseIDField:SecurityResponseIDField,
                                         securityRequestResultField:SecurityRequestResultField,
                                         underlyingInstrumentComponent:Option[UnderlyingInstrumentComponent]=None,
                                         totNoRelatedSymField:Option[TotNoRelatedSymField]=None,
                                         lastFragmentField:Option[LastFragmentField]=None,
                                         relSymDerivSecGrpComponent:Option[RelSymDerivSecGrpComponent]=None) extends SfFixMessageBody("AA")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,securityReqIDField)
    fmt(b,securityResponseIDField)
    fmt(b,securityRequestResultField)
    underlyingInstrumentComponent.foreach(fmt(b,_))
    totNoRelatedSymField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    relSymDerivSecGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object DerivativeSecurityListMessage extends SfFixMessageDecoder {
  val MsgType="AA"
  val MsgName="DerivativeSecurityList"
             
  override val MandatoryFields = HashSet[Int](
    SecurityReqIDField.TagId, SecurityResponseIDField.TagId, SecurityRequestResultField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UnderlyingInstrumentComponent.isMandatoryField(tagId) || RelSymDerivSecGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TotNoRelatedSymField.TagId, LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UnderlyingInstrumentComponent.isOptionalField(tagId) || RelSymDerivSecGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UnderlyingInstrumentComponent.isFieldOf(tagId) || RelSymDerivSecGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SecurityReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(DerivativeSecurityListMessage(SecurityReqIDField.decode(myFields.get(SecurityReqIDField.TagId)).get,
        SecurityResponseIDField.decode(myFields.get(SecurityResponseIDField.TagId)).get,
        SecurityRequestResultField.decode(myFields.get(SecurityRequestResultField.TagId)).get,
        UnderlyingInstrumentComponent.decode(flds, startPos),
        myFields.get(TotNoRelatedSymField.TagId).flatMap(f=>TotNoRelatedSymField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        RelSymDerivSecGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     