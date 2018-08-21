package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class DerivativeSecurityListUpdateReportMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                                     securityReqIDField:Option[SecurityReqIDField]=None,
                                                     securityResponseIDField:Option[SecurityResponseIDField]=None,
                                                     securityRequestResultField:Option[SecurityRequestResultField]=None,
                                                     securityUpdateActionField:Option[SecurityUpdateActionField]=None,
                                                     underlyingInstrumentComponent:Option[UnderlyingInstrumentComponent]=None,
                                                     derivativeSecurityDefinitionComponent:Option[DerivativeSecurityDefinitionComponent]=None,
                                                     transactTimeField:Option[TransactTimeField]=None,
                                                     totNoRelatedSymField:Option[TotNoRelatedSymField]=None,
                                                     lastFragmentField:Option[LastFragmentField]=None,
                                                     relSymDerivSecUpdGrpComponent:Option[RelSymDerivSecUpdGrpComponent]=None) extends SfFixMessageBody("BR")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    securityReqIDField.foreach(fmt(b,_))
    securityResponseIDField.foreach(fmt(b,_))
    securityRequestResultField.foreach(fmt(b,_))
    securityUpdateActionField.foreach(fmt(b,_))
    underlyingInstrumentComponent.foreach(fmt(b,_))
    derivativeSecurityDefinitionComponent.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    totNoRelatedSymField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    relSymDerivSecUpdGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object DerivativeSecurityListUpdateReportMessage extends SfFixMessageDecoder {
  val MsgType="BR"
  val MsgName="DerivativeSecurityListUpdateReport"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || UnderlyingInstrumentComponent.isMandatoryField(tagId) || DerivativeSecurityDefinitionComponent.isMandatoryField(tagId) || RelSymDerivSecUpdGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SecurityReqIDField.TagId, SecurityResponseIDField.TagId, SecurityRequestResultField.TagId, SecurityUpdateActionField.TagId, TransactTimeField.TagId, 
    TotNoRelatedSymField.TagId, LastFragmentField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || UnderlyingInstrumentComponent.isOptionalField(tagId) || DerivativeSecurityDefinitionComponent.isOptionalField(tagId) || RelSymDerivSecUpdGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || UnderlyingInstrumentComponent.isFieldOf(tagId) || DerivativeSecurityDefinitionComponent.isFieldOf(tagId) || 
    RelSymDerivSecUpdGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(DerivativeSecurityListUpdateReportMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(SecurityReqIDField.TagId).flatMap(f=>SecurityReqIDField.decode(f)),
        myFields.get(SecurityResponseIDField.TagId).flatMap(f=>SecurityResponseIDField.decode(f)),
        myFields.get(SecurityRequestResultField.TagId).flatMap(f=>SecurityRequestResultField.decode(f)),
        myFields.get(SecurityUpdateActionField.TagId).flatMap(f=>SecurityUpdateActionField.decode(f)),
        UnderlyingInstrumentComponent.decode(flds, startPos),
        DerivativeSecurityDefinitionComponent.decode(flds, startPos),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(TotNoRelatedSymField.TagId).flatMap(f=>TotNoRelatedSymField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        RelSymDerivSecUpdGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     