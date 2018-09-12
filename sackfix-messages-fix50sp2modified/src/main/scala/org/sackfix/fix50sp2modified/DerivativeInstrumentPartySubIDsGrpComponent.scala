package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class DerivativeInstrumentPartySubIDsGrpComponent(noDerivativeInstrumentPartySubIDsField:Option[NoDerivativeInstrumentPartySubIDsField]=None,
                                                       derivativeInstrumentPartySubIDsGroups: Option[List[DerivativeInstrumentPartySubIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noDerivativeInstrumentPartySubIDsField.map(_.value).getOrElse(0) != derivativeInstrumentPartySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDerivativeInstrumentPartySubIDsField.TagId,noDerivativeInstrumentPartySubIDsField.map(_.value).getOrElse(0), derivativeInstrumentPartySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noDerivativeInstrumentPartySubIDsField.foreach(fmt(b,_))
    derivativeInstrumentPartySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object DerivativeInstrumentPartySubIDsGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    DerivativeInstrumentPartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoDerivativeInstrumentPartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    DerivativeInstrumentPartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    DerivativeInstrumentPartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoDerivativeInstrumentPartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = DerivativeInstrumentPartySubIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DerivativeInstrumentPartySubIDsGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DerivativeInstrumentPartySubIDsGrpComponent(myFields.get(NoDerivativeInstrumentPartySubIDsField.TagId).flatMap(f=>NoDerivativeInstrumentPartySubIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoDerivativeInstrumentPartySubIDsField.TagId)) DerivativeInstrumentPartySubIDsGroup.decode(flds, nextTagPosLookup(NoDerivativeInstrumentPartySubIDsField.TagId)) else None))
    } else None
  }

    
}
     